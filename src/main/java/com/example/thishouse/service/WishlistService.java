package com.example.thishouse.service;

import com.example.thishouse.domain.Wishlist;
import com.example.thishouse.mapper.WishlistMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class WishlistService {

    private final WishlistMapper wishlistMapper;

    public List<HashMap> getFavoritesByUserId(String user_id) {
        return wishlistMapper.getFavoritesByUserId(user_id);
    }

    public void addFavoriteItem(Wishlist wishlist) {
        wishlistMapper.addFavoriteItem(wishlist);
    }

    public void removeFavoriteItem(Wishlist wishlist) {
        wishlistMapper.removeFavoriteItem(wishlist);
    }

    public boolean isHouseLikedByUser(int houseNum, String userId) {
        Wishlist wishlist = new Wishlist();
        wishlist.setHouse_num(houseNum);
        wishlist.setUser_id(userId);
        return wishlistMapper.isHouseLikedByUser(wishlist) != null;
    }

    public List<Wishlist> getWishlistForUser(String user_id, int house_num) {
        return wishlistMapper.getWishlistForUser(user_id, house_num);
    }

    public boolean isInWishlist(String user_id, int houseNum) {
        List<Wishlist> wishlistForUser = wishlistMapper.getWishlistForUser(user_id, houseNum);
        return wishlistForUser != null;
    }

}
