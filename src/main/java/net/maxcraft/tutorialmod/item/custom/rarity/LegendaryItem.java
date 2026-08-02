package net.maxcraft.tutorialmod.item.custom.rarity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LegendaryItem extends Item {
    public LegendaryItem(Settings settings) {
        super(settings);
    }

    @Override
    public Text getName(ItemStack stack) {
        MutableText baseText = super.getName(stack).copy();
        String fullText = baseText.getString();
        List<Text> characterComponents = new ArrayList<>();

        long time = System.currentTimeMillis();

        long animationSpeedMillis = 500L;
        float characterOffset = 0.8f;

        Color baseColorRaw = new Color(200, 80, 0);
        Color shimmerColorRaw = new Color(255, 240, 180);

        int currentIndex = 0;

        for (int i = 0; i < fullText.length(); i++) {
            char c = fullText.charAt(i);

            if (Character.isWhitespace(c)) {
                characterComponents.add(Text.literal(String.valueOf(c)));
                continue;
            }

            double waveInput = (time / (double)animationSpeedMillis) - (currentIndex * characterOffset);

            TextColor interpolatedColor = getInterpolatedColor(waveInput, baseColorRaw, shimmerColorRaw);

            characterComponents.add(
                    Text.literal(String.valueOf(c))
                            .setStyle(Style.EMPTY.withColor(interpolatedColor))
            );

            currentIndex++;
        }

        MutableText finalText = Text.empty();
        for (Text component : characterComponents) {
            finalText.append(component);
        }

        return finalText;
    }

    private static @NotNull TextColor getInterpolatedColor(double waveInput, Color baseColorRaw, Color shimmerColorRaw) {
        double sineValue = (Math.sin(waveInput) + 1.0) / 2.0;

        float t = (float) Math.pow(sineValue, 4.0);

        int r = (int) (baseColorRaw.getRed() + t * (shimmerColorRaw.getRed() - baseColorRaw.getRed()));
        int g = (int) (baseColorRaw.getGreen() + t * (shimmerColorRaw.getGreen() - baseColorRaw.getGreen()));
        int b = (int) (baseColorRaw.getBlue() + t * (shimmerColorRaw.getBlue() - baseColorRaw.getBlue()));

        return TextColor.fromRgb(new Color(r, g, b).getRGB());
    }
}