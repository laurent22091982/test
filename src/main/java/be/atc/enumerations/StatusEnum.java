package be.atc.enumerations;

public enum StatusEnum {
    WAITING("En attente"),
    VALIDATED("Validé");

    private final String label;

    StatusEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
