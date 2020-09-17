import { NativeModules } from 'react-native';

type RnDriverSafetyType = {
  multiply(a: number, b: number): Promise<number>;
  enable(a:  string): any;
};

const { RnDriverSafety } = NativeModules;

export default RnDriverSafety as RnDriverSafetyType;
