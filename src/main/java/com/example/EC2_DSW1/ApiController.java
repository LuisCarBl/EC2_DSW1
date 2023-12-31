package com.example.EC2_DSW1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

//import org.springframework.jdbc.core.JdbcTemplate;
//import java.util.List;
//import java.util.Map;
//import java.lang.String;




@Controller // This means that this class is a Controller
@RequestMapping(path="/api") // This means URL's start with /demo (after Application path)
public class ApiController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private cursoRepository cursoRepository;

  //@Autowired
  //private JdbcTemplate jdbcTemplate;

  @GetMapping(path="/api/curso/listar")
	public @ResponseBody Iterable<Curso> getAllCursos() {
		return cursoRepository.findAll();
	}

  @PostMapping(path="/api/curso/nuevo") // Map ONLY POST Requests
	public @ResponseBody String addNewCurso (@RequestParam String nombre
			, @RequestParam String creditos) {
		Curso c = new Curso();
		c.setNombre(nombre);
		c.setCreditos(creditos);
		cursoRepository.save(c);
		return "Saved";
	}

	@DeleteMapping(path="/api/curso/eliminar")
	public @ResponseBody String delCurso (@RequestParam Integer id) {
		Curso n = new Curso();
		n.setId(id);
		cursoRepository.delete(n);
		return "Deleted";
	}

  @GetMapping(path="/all")     // http://localhost:8080/demo/all
  public @ResponseBody Iterable<Curso> getAllUsers() {
    // This returns a JSON or XML with the users
    return cursoRepository.findAll();
  }

  @PutMapping(path="/edit")
  public @ResponseBody String editUser(@RequestParam Integer id, @RequestParam String nombre, @RequestParam String creditos) {
    Curso n = new Curso();
    n.setId(id);
    n.setNombre(nombre);
    n.setCreditos(creditos);
    cursoRepository.save(n);
    return "Updated";
  }

  @GetMapping(path="/ver/{id}")
  public @ResponseBody Curso getOneUser(@PathVariable Integer id) {
    return cursoRepository.findById(id).orElse(null);
  }

  @DeleteMapping(path="/del")
  public @ResponseBody String deleteUser(@RequestParam Integer id) {
    Curso n = new Curso();
    n.setId(id);
    cursoRepository.delete(n);
    return "Deleted";
  }

  // @GetMapping(path="/get/report")
  // public @ResponseBody List reporte() {
  //  String sql = "SELECT CONCAT(name, ' ==> ', email) as mycol FROM user";
  //  List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
  //  return results;
  // }





}
