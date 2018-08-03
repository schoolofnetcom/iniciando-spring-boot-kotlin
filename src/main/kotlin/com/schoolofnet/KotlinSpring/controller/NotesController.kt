package com.schoolofnet.KotlinSpring.controller

import org.springframework.web.bind.annotation.*
import com.schoolofnet.KotlinSpring.model.Note
import com.schoolofnet.KotlinSpring.repository.NoteRepository
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/notes")
class NotesController(val noteRepository: NoteRepository) {
	
	@GetMapping("/")
	fun findAll() =
		noteRepository.findAll()
			
	@GetMapping("/{id}")
	fun findById(@PathVariable(value = "id") id: Long): ResponseEntity<Note> {
		return noteRepository.findById(id).map { note ->
			ResponseEntity.ok(note)
		}.orElse(ResponseEntity.notFound().build())
	}
//					
	@PostMapping("/")
	fun create(@RequestBody note: Note) =
		noteRepository.save(note)
//	
	@PutMapping("/{id}")
	fun update(@PathVariable(value = "id") id: Long, @RequestBody note: Note): ResponseEntity<Note> {
		return noteRepository.findById(id).map { note ->
			val updated : Note = note.copy(title = note.title, body = note.body)
			
			ResponseEntity.ok().body(noteRepository.save(updated))
		}.orElse(ResponseEntity.notFound().build())
	}
//
	@DeleteMapping("/{id}")
	fun remove(@PathVariable(value = "id") id: Long) =
		noteRepository.deleteById(id)
}