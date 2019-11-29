package pl.koszela.calculator.calculatormvc.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "repo_accesories")
public interface AccesoriesRepository extends JpaRepository<Accessories, Long> {
}