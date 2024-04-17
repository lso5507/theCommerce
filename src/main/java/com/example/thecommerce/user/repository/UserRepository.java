package com.example.thecommerce.user.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thecommerce.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	Slice<User> findSliceBy(Pageable pageable);
}
