package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.NegativeQuantityException;
import core.basesyntax.models.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new NegativeQuantityException(
                "Quantity is negative for fruit " + fruitTransaction.getFruit());
        }
        Integer oldQuantity = Storage.fruitMap.getOrDefault(fruitTransaction.getFruit(), 0);
        Storage.fruitMap.put(fruitTransaction.getFruit(),
                oldQuantity + fruitTransaction.getQuantity());
    }
}