/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> getAllUsers();

    @Insert("INSERT INTO users (name, email, tanggal_lahir, alamat) VALUES (#{name}, #{email}, #{tanggalLahir}, #{alamat})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(User user);

    @Update("UPDATE users SET name = #{name}, email = #{email}, tanggal_lahir = #{tanggalLahir}, alamat = #{alamat} WHERE id = #{id}")
    void updateUser(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteUser(int id);
}

