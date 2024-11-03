package uniandes.edu.co.proyecto.servicios;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Repositories.InfoExtraBodegaRepository;
import uniandes.edu.co.proyecto.Repositories.InfoExtraOrdenRepository;
import uniandes.edu.co.proyecto.Repositories.OrdenCompraRepository;
import uniandes.edu.co.proyecto.Repositories.RecepcionProductosRepository;
import uniandes.edu.co.proyecto.modelo.RecepcionProductos;
import uniandes.edu.co.proyecto.modelo.InfoExtraOrden;

@Service
public class RecepcionProductosServicio {
    @Autowired
    RecepcionProductosRepository recepcionProductosRepository;

    @Autowired
    InfoExtraOrdenRepository infoExtraOrdenRepository;
    @Autowired
    InfoExtraBodegaRepository infoExtraBodegaRepository;
    @Autowired
    OrdenCompraRepository ordenCompraRepository;
    
    @Transactional (isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public void InsertarRecepcion( RecepcionProductos documento) throws Exception {
        try {
            recepcionProductosRepository.insertRecepcionProductos(documento.getId(),documento.getFechaRecepcion(), documento.getId_Bodega().getId(), documento.getId_OrdenCompra().getId());
            Collection<InfoExtraOrden> productos = infoExtraOrdenRepository.getInfoExtraOrdenpororden(documento.getId_OrdenCompra().getId());
            
            for (InfoExtraOrden producto : productos){
                infoExtraBodegaRepository.ActualizarCantidadyprecio(producto.getPk().getCantidad(), producto.getPk().getCostoUnitarioCompra(), producto.getPk().getCodigoBarras().getCodigoBarras());
            }
            ordenCompraRepository.Entregada(documento.getId_Bodega().getId());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Transactional(readOnly = true, isolation = Isolation.SERIALIZABLE)
    public Collection<RecepcionProductos> docPorId( Long idBodega, Long idSucursal) throws InterruptedException{
        Collection<RecepcionProductos> docs= recepcionProductosRepository.documentosporId(idBodega, idSucursal);
        System.out.println(docs.size());
        Thread.sleep(30000);
        docs = recepcionProductosRepository.documentosporId(idBodega, idSucursal);
        return docs;
    }   

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public Collection<RecepcionProductos> documentosPorIdespecifico( Long idBodega, Long idSucursal) throws InterruptedException{
        Collection<RecepcionProductos> docs= recepcionProductosRepository.documentosporId(idBodega, idSucursal);
        System.out.println(docs.size());
        Thread.sleep(30000);
        docs = recepcionProductosRepository.documentosporId(idBodega,idSucursal);
        return docs;
    }

}
