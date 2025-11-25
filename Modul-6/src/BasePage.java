public abstract class BasePage implements CLIpage {
    // BasePage sekarang hanya menangani identitas visual (Judul), bukan input.
    // Tanggung jawab input diserahkan ke child class via InputReader.

    protected void displayTitle() {
        System.out.println("\n--- " + getName().toUpperCase() + " ---");
    }
}