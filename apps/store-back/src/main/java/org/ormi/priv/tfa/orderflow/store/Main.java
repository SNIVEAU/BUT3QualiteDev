package org.ormi.priv.tfa.orderflow.store;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

/**
 * Point d'entrée principal du service Store Back.
 * <p>
 * Cette classe démarre l'application Quarkus en utilisant la classe interne
 * {@link ProductRegistryDomainApplication} qui attend la terminaison du processus.
 * </p>
 */

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(
            ProductRegistryDomainApplication.class,
            (exitCode, exception) -> {},
            args);
    }

    /**
     * Application Quarkus pour le domaine du registre produit.
     * <p>
     * Attend la terminaison du processus Quarkus.
     * </p>
     */
    public static class ProductRegistryDomainApplication implements QuarkusApplication {

        @Override
        public int run(String... args) throws Exception {
            Quarkus.waitForExit();
            return 0;
        }
    }
}
