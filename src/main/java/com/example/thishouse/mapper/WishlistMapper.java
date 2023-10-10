package com.example.thishouse.mapper;


import com.example.thishouse.domain.Wishlist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WishlistMapper {

    List<Wishlist> getFavoritesByUserId(@Param("user_id") String user_id);

    void addFavoriteItem(Wishlist wishlist);

    void removeFavoriteItem(@Param("user_id") String user_id, @Param("house_num") int houseNum);

}
