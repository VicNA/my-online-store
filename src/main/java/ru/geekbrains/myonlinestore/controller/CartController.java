package ru.geekbrains.myonlinestore.controller;

import lombok.RequiredArgsConstructor;
import ru.geekbrains.myonlinestore.services.ShoppingCartService;
import ru.geekbrains.myonlinestore.utils.ShoppingCart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final ShoppingCartService shoppingCartService;

    @GetMapping
    public String cartPage(Model model, HttpSession httpSession) {
        ShoppingCart cart = shoppingCartService.getCurrentCart(httpSession);
        model.addAttribute("cart", cart);
        return "cart-page";
    }
}
