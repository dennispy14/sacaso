import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FaseControllerImpl implements FaseController {

    private final FaseService faseService;

    @Override
    public ResponseEntity<List<FaseResponse>> listar() {
        return ResponseEntity.ok(faseService.listarFases());
    }
}
