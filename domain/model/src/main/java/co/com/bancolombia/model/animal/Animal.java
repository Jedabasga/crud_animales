package co.com.bancolombia.model.animal;
import lombok.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    private String id;
    private String especie;
    private long numpatas;
    private String genero;
    private String habitad;
    private boolean domestico;

}
