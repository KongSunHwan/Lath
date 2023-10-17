package com.example.thishouse.controller;

import com.example.thishouse.domain.Wishlist;
import com.example.thishouse.service.WishlistService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WishlistController {
    private final WishlistService wishlistService;

    @GetMapping("/wishlist/{user_id}")
    public String getFavoritesByUserId(@PathVariable String user_id, Model model) {
        List<HashMap> favorites = wishlistService.getFavoritesByUserId(user_id);
        model.addAttribute("favorites", favorites);
        return "steamed/steamed_list";
    }

    @PostMapping("/wishlist/add")
    @ResponseBody
    public ResponseEntity<String> addFavoriteItem(@RequestBody Wishlist wishlist, HttpSession session) {
        wishlistService.addFavoriteItem(wishlist);

        session.setAttribute("user_wishlist", wishlist);

        System.out.println("wishlist = " + wishlist);
        System.out.println("wishlist.getUser_id = " + wishlist.getUser_id());
        System.out.println("wishlist.getHouse_num = " + wishlist.getHouse_num());

        return ResponseEntity.ok("Saving is complete.");
    }

    @DeleteMapping("/wishlist/remove")
    @ResponseBody
    public ResponseEntity<String> removeFavoriteItem(@RequestBody Wishlist wishlist, HttpSession session) {

        wishlistService.removeFavoriteItem(wishlist);
        Wishlist userWishlist = (Wishlist) session.getAttribute("user_wishlist");

        System.out.println("userWishlist = " + userWishlist);
        System.out.println("userWishlist.getUser_id = " + userWishlist.getUser_id());
        System.out.println("userWishlist.getHouse_num = " + userWishlist.getHouse_num());

        return ResponseEntity.ok("Removal of items has been completed.");
    }

    @GetMapping("/wishlist/check")
    public boolean isHouseLikedByUser(@RequestParam int houseNum, HttpSession session) {
        String user_id = (String) session.getAttribute("user_id");
        return wishlistService.isHouseLikedByUser(houseNum, user_id);
    }

}
