
package com.br.globo.signature.infra.extractor;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 26/08/2021
 */
@FunctionalInterface
public interface Extractor<T, D> {

    D extract(final T extract);

}
