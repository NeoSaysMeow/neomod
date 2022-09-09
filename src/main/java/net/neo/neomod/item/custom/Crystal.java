package net.neo.neomod.item.custom;

import java.util.List;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;

import javax.annotation.Nullable;

public class Crystal {
    @Nullable
    private final String baseName;
    private final ImmutableList<EntityType<?>> type;

    public static Crystal byId(String id) {
        return ModRegistry.CRYSTAL.get(Identifier.tryParse(id));
    }
    public Crystal(EntityType<?>... type) {
        this((String)null, type);
    }

    public Crystal(@Nullable String baseName, EntityType<?> ... type) {
        this.baseName = baseName;
        this.type = ImmutableList.copyOf(type);
    }

    public String finishTranslationKey(String prefix) {
        return prefix + (this.baseName == null ? ModRegistry.CRYSTAL.getId(this).getPath() : this.baseName);
    }

    public List<EntityType<?>> getType() {
        return this.type;
    }

}
