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

    public WishDTO.PageResponseList getFavoritesByUserId(String user_id, Criteria criteria,
                                                         String houseType, String dealType,
                                                         String area) {
        String sqlOption = "";

        if (houseType != null && !houseType.equals("전체")) {
            sqlOption += "AND a.house_type = #{houseType}";
        }

        if (dealType != null && !dealType.equals("전체")) {
            sqlOption += "AND a.deal_type = #{dealType}";
        }
        if (area != null && !area.equals(10000)) {
            sqlOption += "AND a.exclusive_area2 < #{dealType}";
        }
        System.out.println("테스트할 내용 sql : " + sqlOption);

        Criteria cs = new Criteria(criteria.getPageNum(), 14);
        List<WishDTO> pageList = wishlistMapper.getFavoritesByUserId(user_id, cs, sqlOption, houseType, dealType, area);
        log.info("pageList={}", pageList);
        int total = wishlistMapper.findCount(cs);
        PageDTO pageDTO = new PageDTO(cs, total);
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
