package ru.geekbrains.myonlinestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.myonlinestore.entites.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
