package com.zetavn.api.repository;

import com.zetavn.api.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findUserEntityByEmail(String email);
    UserEntity findUserEntityByUsername(String username);

    @Query("SELECT o FROM UserEntity o WHERE o.username LIKE ?1 OR o.email LIKE ?2")
    UserEntity findUserEntityByUsernameAndEmail(String username, String email);

    @Query("SELECT o FROM UserEntity o WHERE o.lastName LIKE %?1% OR o.firstName LIKE %?1%")
    Page<UserEntity> findUserEntityByKeyword(String keyword,
                                             Pageable pageable);

}
