package hh.backend.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    private CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/categorylist")
    public String categoryList(Model model) {
        model.addAttribute("categories", repository.findAll());
        return "categorylist";
    }

    @GetMapping("/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping("/savecategory")
    public String saveCategory(Category category) {
        repository.save(category);
        return "redirect:/categorylist";
    }
}
