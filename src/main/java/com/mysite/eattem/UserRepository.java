package com.mysite.eattem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<EattemUser, Integer> {

}
