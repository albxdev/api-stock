package com.emazon.stock.domain.spi;

import com.emazon.stock.domain.exception.BrandNotFoundException; // Asegúrate de que la importación esté presente
import com.emazon.stock.domain.model.Brand;
import java.util.List;

/**
 * Interface que define los métodos para la persistencia de marcas.
 */
public interface IBrandPersistencePort {

    /**
     * Crea una nueva marca en la base de datos.
     *
     * @param brand La marca a crear.
     * @throws IllegalArgumentException si la marca es inválida.
     */
    void createBrand(Brand brand);

    /**
     * Actualiza una marca existente en la base de datos por su ID.
     *
     * @param id El ID de la marca a actualizar.
     * @param brand La marca con los nuevos datos.
     * @throws IllegalArgumentException si el ID es negativo o cero.
     * @throws BrandNotFoundException si no se encuentra una marca con el ID proporcionado.
     */
    void updateBrandById(Long id, Brand brand);

    /**
     * Elimina una marca de la base de datos por su ID.
     *
     * @param id El ID de la marca a eliminar.
     * @throws BrandNotFoundException si no se encuentra una marca con el ID proporcionado.
     */
    void deleteBrandById(Long id);

    /**
     * Verifica si una marca existe por su nombre.
     *
     * @param name El nombre de la marca a verificar.
     * @return true si la marca existe, false en caso contrario.
     */
    boolean existsByName(String name);

    /**
     * Verifica si una marca existe por su ID.
     *
     * @param id El ID de la marca a verificar.
     * @return true si la marca existe, false en caso contrario.
     */
    boolean existsById(Long id);

    /**
     * Obtiene una marca por su ID.
     *
     * @param id El ID de la marca a obtener.
     * @return La marca correspondiente al ID proporcionado.
     * @throws IllegalArgumentException si el ID es negativo o cero.
     * @throws BrandNotFoundException si no se encuentra una marca con el ID proporcionado.
     */
    Brand getBrandById(Long id);

    /**
     * Lista las marcas con paginación y ordenación opcional.
     *
     * @param page Número de página para la paginación.
     * @param size Número de elementos por página.
     * @param sortBy El criterio de ordenación (por ejemplo, "name" o "id").
     * @param asc Indica si el orden es ascendente o descendente.
     * @return Una lista de marcas.
     */
    List<Brand> listBrands(Integer page, Integer size, String sortBy, Boolean asc);
}
