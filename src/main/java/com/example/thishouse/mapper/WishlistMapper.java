package com.example.thishouse.mapper;


import com.example.thishouse.domain.Criteria;
import com.example.thishouse.domain.DTO.WishDTO;
import com.example.thishouse.domain.Wishlist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface WishlistMapper {

    List<WishDTO> getFavoritesByUserId(@Param("user_id") String user_id,
                                                @Param("criteria") Criteria criteria);

    int findCount(Criteria criteria);

    void addFavoriteItem(Wishlist wishlist);

    void removeFavoriteItem(Wishlist wishlist);

    Boolean isHouseLikedByUser(Wishlist wishlist);

    List<Wishlist> getWishlistForUser(String user_id, int house_num);

}
