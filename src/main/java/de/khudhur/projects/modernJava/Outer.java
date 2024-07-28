package de.khudhur.projects.modernJava;

public class Outer {
    private class Inner{
        private String name;
        public Inner(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return Inner.class.getSimpleName() + " {name: " + name + "}";
        }
    }

    private String className;
    private Inner inner;
    public Outer(String className, String innerName) {
        this.className = className;
        inner = new Inner(innerName);
    }

    @Override
    public String toString() {
        return Outer.class.getSimpleName() + " {name: " + className + "}\n" + inner.toString();
    }
}
