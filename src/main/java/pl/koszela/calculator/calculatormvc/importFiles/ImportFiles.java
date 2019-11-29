package pl.koszela.calculator.calculatormvc.importFiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.koszela.calculator.calculatormvc.DAOs.Dao;
import pl.koszela.calculator.calculatormvc.model.Accessories;

import java.util.Objects;

@Service
public class ImportFiles {

    private Dao dao;

    public ImportFiles(Dao dao) {
        this.dao = Objects.requireNonNull(dao);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void csv() {
        dao.readAndSaveToORMTest(FILE_AKCESORIA_URL);
    }

    private static final String FILE_AKCESORIA_URL = "src/main/resources/assets/akcesoria.csv";

}