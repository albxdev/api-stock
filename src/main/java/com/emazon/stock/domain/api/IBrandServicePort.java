package com.emazon.stock.domain.api;

import com.emazon.stock.domain.exception.BrandAlreadyExistsException; // Asegúrate de que la importación esté presente
import com.emazon.stock.domain.exception.BrandNotFoundException; // Asegúrate de que la importación esté presente
import com.emazon.stock.domain.model.Brand;
import java.util.List;

/**
 * Interface que define los casos de uso para la gestión de marcas.
 */
public interface IBrandServicePort {

    /**
     * Crea una nueva marca.
     *
     * @param brand La marca a crear.
     * @throws IllegalArgumentException si la marca es inválida.
     * @throws BrandAlreadyExistsException si una marca con el mismo nombre ya existe.
     */
    void createBrand(Brand brand);

    /**
     * Actualiza una marca existente por su ID.
     *
     * @param id El ID de la marca a actualizar.
     * @param brand La marca con los nuevos datos.
     * @throws IllegalArgumentException si el ID es negativo o cero.
     * @throws BrandNotFoundException si no se encuentra una marca con el ID proporcionado.
     */
    void updateBrandById(Long id, Brand brand);

    /**
     * Elimina una marca por su ID.
     *
     * @param id El ID de la marca a eliminar.
     * @throws BrandNotFoundException si no se encuentra una marca con el ID proporcionado.
     */
    void deleteBrandById(Long id);

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
     * @param sortByName Indica si se debe ordenar por nombre.
     * @param asc Indica si el orden es ascendente o descendente.
     * @return Una lista de marcas.
     */
    List<Brand> listBrands(Integer page, Integer size, Boolean sortByName, Boolean asc);
}
