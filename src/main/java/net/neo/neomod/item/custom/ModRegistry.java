package net.neo.neomod.item.custom;

import com.mojang.serialization.Keyable;
import com.mojang.serialization.Lifecycle;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.IndexedIterable;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public abstract class ModRegistry<T> implements Keyable, IndexedIterable {
    public static final RegistryKey<Registry<Crystal>> CRYSTAL_KEY = ModRegistry.createRegistryKey("crystal");
    public final DefaultedRegistry<Crystal> CRYSTAL = (DefaultedRegistry<Crystal>) Registry.create(CRYSTAL_KEY, "pig", (Registry<T> registry) -> Crystals.PIG);


    private static <T> RegistryKey<Registry<T>> createRegistryKey(String registryId) {
        return RegistryKey.ofRegistry(new Identifier(registryId));
    }

    private static <T> DefaultedRegistry<T> create(RegistryKey<? extends Registry<T>> key, String defaultId, ModRegistry.DefaultEntryGetter<T> defaultEntryGetter) {
        return ModRegistry.create(key, defaultId, defaultEntryGetter);
    }

    @FunctionalInterface
    static interface DefaultEntryGetter<T> {
        public T run(Registry<T> var1);
    }
}
