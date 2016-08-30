package br.edu.ifrn.projetobraile;

import br.edu.ifrn.projetobraile.dominio.App;

public final class MySingleton {

    private static MySingleton instance = new MySingleton();
    private static App app = new App();

    private MySingleton() {
        super();
    }

    public static App getApp() { return app; }
    public static MySingleton getInstance() {
        return instance;
    }

}