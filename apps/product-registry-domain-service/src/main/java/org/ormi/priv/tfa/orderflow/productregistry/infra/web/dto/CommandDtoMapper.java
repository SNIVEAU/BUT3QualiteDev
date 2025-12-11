package org.ormi.priv.tfa.orderflow.productregistry.infra.web.dto;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.ormi.priv.tfa.orderflow.productregistry.application.ProductCommand.RegisterProductCommand;
import org.ormi.priv.tfa.orderflow.contracts.productregistry.v1.write.RegisterProductCommandDto;
import org.ormi.priv.tfa.orderflow.kernel.product.SkuIdMapper;

/**
 * Mapper MapStruct pour convertir entre les DTO de commande et les objets métier du registre produit.
 * <p>
 * Facilite la transformation entre {@link RegisterProductCommandDto} et {@link RegisterProductCommand}.
 * </p>
 */

@Mapper(
    componentModel = "cdi",
    builder = @Builder(disableBuilder = true),
    uses = { SkuIdMapper.class },
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CommandDtoMapper {
    public RegisterProductCommand toCommand(RegisterProductCommandDto dto);
    public RegisterProductCommandDto toDto(RegisterProductCommand command);
}
