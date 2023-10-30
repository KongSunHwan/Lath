package com.example.thishouse.service;

import com.example.thishouse.domain.Criteria;
import com.example.thishouse.domain.DTO.WishDTO;
import com.example.thishouse.domain.PageDTO;
import com.example.thishouse.domain.Wishlist;
import com.example.thishouse.mapper.WishlistMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WishlistService {

    private final WishlistMapper wishlistMapper;

    public WishDTO.PageResponseList getFavoritesByUserId(String user_id, Criteria criteria) {
        Criteria cs = new Criteria(criteria.getPageNum(), 14);
        List<WishDTO> pageList = wishlistMapper.getFavoritesByUserId(user_id, cs);
        log.info("pageList={}", pageList);
        int total = wishlistMapper.findCount(cs);
        PageDTO pageDTO = new PageDTO(cs,total);
        return new WishDTO.PageResponseList(pageList, pageDTO);
    }

    public List<HashMap> getMyPageFavoritesByUserId(String user_id) {
        return wishlistMapper.getMyPageFavoritesByUserId(user_id);
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
