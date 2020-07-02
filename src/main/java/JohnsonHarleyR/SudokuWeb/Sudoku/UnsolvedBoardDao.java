package JohnsonHarleyR.SudokuWeb.Sudoku;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UnsolvedBoardDao extends JpaRepository<UnsolvedBoard, Long> {
	
	Optional<UnsolvedBoard> findById(Long id);
	CompleteBoard findByCompleteId(Long completeId);
	
}
