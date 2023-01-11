package servidor;

class AdNotFoundException extends RuntimeException {

	AdNotFoundException(Long id) {
		super("Could not find Ad " + id);
	}
}
