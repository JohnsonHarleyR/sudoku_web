package JohnsonHarleyR.SudokuWeb.Sudoku;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompleteBoardDao extends JpaRepository<CompleteBoard, Long> {
	
	Optional<CompleteBoard> findById(Long id);
	
}
