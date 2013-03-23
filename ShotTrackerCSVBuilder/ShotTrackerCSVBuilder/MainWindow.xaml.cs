using Microsoft.Win32;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace WpfApplication1
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class ShotTrackerCSVBuilder : Window
    {
        public ShotTrackerCSVBuilder()
        {
            InitializeComponent();
        }
        private String imageFile = String.Empty;
        private void FileButton_Click(object sender, RoutedEventArgs e)
        {
            OpenFileDialog openDialog = new OpenFileDialog();
            if (openDialog.ShowDialog().Value)
            {
                imageFile = openDialog.FileName;
            }
        }

        private void AppendToFile(object sender, RoutedEventArgs e)
        {
            String line = String.Format("{0},{1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11},{12}",
                Type.Text, Manufacturer.Text, Produced.Text, Variants.Text, Weight.Text,
                Length.Text, BarrelLength.Text, Cartridge.Text, Action.Text, MuzzleVelocity.Text,
                FeedSystem.Text, Sights.Text, GeneralInfoBox.Text, imageFile);

            using (StreamWriter writer = new StreamWriter("Weapons.csv", true))
            {
                writer.WriteLine(line);
            }

            resetFields();

        }

        private void resetFields()
        {
            Type.Text = String.Empty;
            Manufacturer.Text = String.Empty;
            Produced.Text = String.Empty;
            Variants.Text = String.Empty;
            Weight.Text = String.Empty;
            Length.Text = String.Empty;
            BarrelLength.Text = String.Empty;
            Cartridge.Text = String.Empty;
            Action.Text = String.Empty;
            MuzzleVelocity.Text = String.Empty;
            FeedSystem.Text = String.Empty;
            Sights.Text = String.Empty;
            GeneralInfoBox.Text = String.Empty;
            imageFile = String.Empty;
        }
    }
}
