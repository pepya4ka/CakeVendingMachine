public enum Newspaper {

    PROMOTIONAL_AND_INFORMATIONAL("Вода", 10, 1),//Пирожок
    ENTERTAINING("Газировка", 20, 2),//Булочка
    DAILY("Сок", 30, 3),//Тортик
    WEEKLY("Содовая", 40, 4);//Кекс

    private String title;
    private int price;
    private int number;

    Newspaper(String title, int price, int number) {
        this.title = title;
        this.price = price;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getNumber() {
        return number;
    }
}
