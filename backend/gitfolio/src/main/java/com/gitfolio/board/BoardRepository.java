package com.gitfolio.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    public Optional<List<Board>> findByRegisterIdOrderByRegisterDateTimeDesc(Long id);
    public void deleteBoardById(Long id);
}
