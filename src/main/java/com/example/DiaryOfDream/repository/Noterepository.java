package com.example.DiaryOfDream.repository;

import com.example.DiaryOfDream.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Noterepository extends JpaRepository<Note, Long> {

}
