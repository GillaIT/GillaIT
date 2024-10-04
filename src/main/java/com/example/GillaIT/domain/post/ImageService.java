package com.example.GillaIT.domain.post;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import com.example.GillaIT.domain.entity.Image;
import com.example.GillaIT.domain.entity.Post;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ImageService {

    private final AmazonS3 amazonS3;
    private final PostRepository postRepository;
    private final ImageRepository imageRepository;

    @Value("${spring.aws.s3.bucket-name}")
    private String bucketName;

    @Transactional
    public void savePostImages(Post post, List<MultipartFile> files) {
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            String s3Key = "post-images/" + post.getId() + "/" + fileName;

            try {
                ObjectMetadata metadata = new ObjectMetadata();
                metadata.setContentType(file.getContentType());
                amazonS3.putObject(bucketName, s3Key, file.getInputStream(), metadata);
            } catch (IOException e) {
                log.error("이미지를 업로드하지 못했습니다. ", e);
            }

            Image image = new Image();
            image.setFileName(fileName);
            image.setS3Key(s3Key);
            image.setPost(post);

            imageRepository.save(image);

            post.getPostImages().add(image);
        }
        postRepository.save(post);
    }

    public byte[] getPostImage(String s3Key) {
        try {
            S3Object s3Object = amazonS3.getObject(bucketName, s3Key);
            return IOUtils.toByteArray(s3Object.getObjectContent());
        } catch (IOException e) {
            log.error("이미지를 불러올 수 없습니다. ", e);
        }
        return null;
    }
}
