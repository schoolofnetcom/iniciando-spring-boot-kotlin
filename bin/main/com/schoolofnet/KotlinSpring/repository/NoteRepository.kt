package com.schoolofnet.KotlinSpring.repository

import org.springframework.data.repository.CrudRepository
import com.schoolofnet.KotlinSpring.model.Note

interface NoteRepository : CrudRepository<Note, Long> {}