package servicios;

public interface ISujeto {
    void registrarObservador(IObservador o);
    void removerObservador(IObservador o);
    void notificarObservadores();
}
