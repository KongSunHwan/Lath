package com.example.thishouse.service;

import com.example.thishouse.domain.Wishlist;
import com.example.thishouse.mapper.WishlistMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class WishlistService {

    private final WishlistMapper wishlistMapper;

    public List<Wishlist> getFavoritesByUserId(String user_id) {
        return wishlistMapper.getFavoritesByUserId(user_id);
    }

    public void addFavoriteItem(Wishlist wishlist) {
        wishlistMapper.addFavoriteItem(wishlist);
    }

    public void removeFavoriteItem(String user_id, int houseNum) {
        wishlistMapper.removeFavoriteItem(user_id, houseNum);
    }
}
