package com.example.EC2_DSW1;

import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface cursoRepository extends CrudRepository<Curso, Integer> {

}