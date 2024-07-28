package de.khudhur.projects.modernJava;

public class Record {
    public record StudiR(String name, int credits) {
        public StudiR(String name, int credits){
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null");
            }
            else {
                this.name = name;
            }

            this.credits = Math.max(credits, 0);
        }
    }
}
