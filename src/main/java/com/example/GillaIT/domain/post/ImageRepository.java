package com.example.GillaIT.domain.post;

import com.example.GillaIT.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
