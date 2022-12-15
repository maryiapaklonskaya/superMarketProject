public class Producer implements Comparable<Producer> {
    // add collection of producers  ( name, totalRevenue )
    private String name;
    private Double totalRevenue;

    public String getName() {
        return name;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Producer(String name, Double totalRevenue){
        this.name = name;
        this.totalRevenue = totalRevenue;
    }

    @Override
    public String toString(){
        return "Producer name: " + name + " total revenue: " + totalRevenue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return (name.toLowerCase().equals(producer.getName().toLowerCase()) && (totalRevenue.equals(producer.getTotalRevenue())));
    }

    @Override
    public int hashCode(){
        int result = name.toLowerCase().hashCode() + totalRevenue.hashCode();
        return result;
    }

    @Override
    public int compareTo(Producer producer){
        return this.name.charAt(0) - producer.getName().charAt(0);
    }

}
