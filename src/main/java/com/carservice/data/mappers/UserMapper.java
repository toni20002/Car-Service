package com.carservice.data.mappers;

import com.carservice.data.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user (" +
            " `username`, " +
            " `email`," +
            " `password`, " +
            " `firstName`, " +
            " `lastName`, " +
            " `phoneNumber`, " +
            " `creationTime`, " +
            " `role`" +
            ")" +
            " VALUES (" +
            " #{user.username}," +
            " #{user.email}," +
            " #{user.password}," +
            " #{user.firstName}," +
            " #{user.lastName}," +
            " #{user.phoneNumber}," +
            " #{user.creationTime}," +
            " #{user.role}" +
            ")")
    boolean registerUser(@Param("user") User user);
}
