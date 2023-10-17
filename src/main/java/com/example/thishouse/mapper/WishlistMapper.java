package com.example.thishouse.mapper;


import com.example.thishouse.domain.Wishlist;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface WishlistMapper {

    List<HashMap> getFavoritesByUserId(String user_id);

    void addFavoriteItem(Wishlist wishlist);

    void removeFavoriteItem(Wishlist wishlist);

    Boolean isHouseLikedByUser(Wishlist wishlist);

    List<Wishlist> getWishlistForUser(String user_id, int house_num);

}
