package pl.koszela.calculator.calculatormvc;

import org.springframework.stereotype.Service;
import pl.koszela.calculator.calculatormvc.model.AccesoriesRepository;
import pl.koszela.calculator.calculatormvc.model.Accessories;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ServiceAccessories {

    private AccesoriesRepository accesoriesRepository;

    public ServiceAccessories(AccesoriesRepository accesoriesRepository) {
        this.accesoriesRepository = Objects.requireNonNull(accesoriesRepository, "Repository accessories cannot be nul");
    }

    private List<Accessories> find() {
        return accesoriesRepository.findAll();
    }

    public void addAccesories(Accessories accessories){
        accesoriesRepository.save(accessories);
    }

    public List<Accessories> find(String category){
        return find()
                .stream()
                .filter(accessories -> accessories.getType().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }
}
