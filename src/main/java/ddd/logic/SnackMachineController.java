package ddd.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/snackmachine")
public class SnackMachineController {

    @Autowired
    SnackMachineRepository snackMachineRepository;

    @GetMapping("/{id}")
    @ResponseBody
    public SnackMachineDto getSnackMachine(@PathVariable("id") long id) {
        return snackMachineRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}/moneyInTransaction/{money}")
    public void insertMoney(@PathVariable("id") long id, @PathVariable("money") String money) {
        SnackMachineDto snackMachineDto = snackMachineRepository.findById(id).orElse(null);
        SnackMachine snackMachine = snackMachineDto.convertToSnackMachine();

        if (money.equalsIgnoreCase("Cent")) {
            snackMachine.insertMoney(Money.CENT);
        } else if (money.equalsIgnoreCase("Dime")) {
            snackMachine.insertMoney(Money.DIME);
        } else if (money.equalsIgnoreCase("Quarter")) {
            snackMachine.insertMoney(Money.QUARTER);
        } else if (money.equalsIgnoreCase("Dollar")) {
            snackMachine.insertMoney(Money.DOLLAR);
        } else if (money.equalsIgnoreCase("FiveDollar")) {
            snackMachine.insertMoney(Money.FIVE_DOLLAR);
        } else if (money.equalsIgnoreCase("TwentyDollar")) {
            snackMachine.insertMoney(Money.TWENTY_DOLLAR);
        }

        snackMachineRepository.save(snackMachine.convertToSnackMachineDto());
    }

    @PutMapping("/{id}/moneyInTransaction")
    public void returnMoney(@PathVariable("id") long id) {
        SnackMachineDto snackMachineDto = snackMachineRepository.findById(id).orElse(null);
        SnackMachine snackMachine = snackMachineDto.convertToSnackMachine();
        snackMachine.returnMoney();
        snackMachineRepository.save(snackMachine.convertToSnackMachineDto());
    }

    @PutMapping("/{id}/{slotNumber}")
    public void buySnack(@PathVariable("id") long id, @PathVariable("slotNumber") int slotNumber) {
        SnackMachineDto snackMachineDto = snackMachineRepository.findById(id).orElse(null);
        SnackMachine snackMachine = snackMachineDto.convertToSnackMachine();
        snackMachine.buySnack();
        snackMachineRepository.save(snackMachine.convertToSnackMachineDto());
    }

}
