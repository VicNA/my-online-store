package ru.geekbrains.myonlinestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.myonlinestore.entites.Product;
import ru.geekbrains.myonlinestore.services.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

    private static final int INITIAL_PAGE = 0;
    private static final int PAGE_SIZE = 5;

    private final ProductService productService;
//    private final ShoppingCartService shoppingCartService;

    @GetMapping
    public String shopPage(Model model,
                           @RequestParam(value = "page") Optional<Integer> page,
                           @RequestParam(value = "word", required = false) String word,
                           @RequestParam(value = "min", required = false) Double min,
                           @RequestParam(value = "max", required = false) Double max
    ) {
        final int currentPage = page.orElse(0) < 1 ? INITIAL_PAGE : page.get() - 1;

        StringBuilder filters = new StringBuilder();

        if (word != null) {
            filters.append("&word=").append(word);
        }
        if (min != null) {
            filters.append("&min=").append(min);
        }
        if (max != null) {
            filters.append("&max=").append(max);
        }

        Page<Product> products = productService.fingAll(currentPage, PAGE_SIZE, word, min, max);

        model.addAttribute("products", products.getContent());
        model.addAttribute("page", currentPage);
        model.addAttribute("totalPage", products.getTotalPages());

        model.addAttribute("filters", filters.toString());

        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("word", word);

        return "shop-page";
    }

    @GetMapping("/cart/add/{id}")
    public String addProductToCart(Model model, @PathVariable("id") Long id, HttpServletRequest request) {
        String referrer = request.getHeader("referer");

        return "redirect:" + referrer;
    }
}
